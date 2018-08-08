package mochico.example.com.pagingsample.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import mochico.example.com.pagingsample.data.Item
import mochico.example.com.pagingsample.data.ItemDb

class ItemViewModel(app: Application) : AndroidViewModel(app) {
    val dao = ItemDb.get(app).itemDao()

    companion object {
        private const val PAGE_SIZE = 10
        private const val ENABLE_PLACEHOLDERS = true
        private const val INITIAL_LOAD_SIZE_HINT = 20
        private const val PREFETCH_DISTANCE = 10
    }

    val allItems = LivePagedListBuilder(
            dao.allItemByName(),
            PagedList.Config.Builder()
                    .setPageSize(PAGE_SIZE)
                    .setEnablePlaceholders(ENABLE_PLACEHOLDERS)
                    .setInitialLoadSizeHint(INITIAL_LOAD_SIZE_HINT)
                    .setPrefetchDistance(PREFETCH_DISTANCE)
                    .build())
            .setBoundaryCallback(object : PagedList.BoundaryCallback<Item>() {
                override fun onZeroItemsLoaded() {
                    Log.d("BoundaryCallback", "onZeroItemsLoaded")
                }

                override fun onItemAtFrontLoaded(itemAtFront: Item) {
                    Log.d("BoundaryCallback", "onItemAtFrontLoaded : " + itemAtFront.id)
                }

                override fun onItemAtEndLoaded(itemAtEnd: Item) {
                    Log.d("BoundaryCallback", "onItemAtEndLoaded : " + itemAtEnd.id)
                }

            })
            .build()

}