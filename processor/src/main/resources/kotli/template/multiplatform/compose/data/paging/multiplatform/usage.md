## Overview

- Integration config: `app.common.CommonConfig`
- Data source: `shared.data.source.paging.PagingSource`
- UI component: `shared.presentation.ui.component.AppPagingList`

## Example

```kotlin
class BasicPagingViewModel(pagingSource: PagingSource) : BaseViewModel() {

    private val allItems = (1..300).map { "Item-$it" }

    val pager = pagingSource.createPager(viewModelScope) { limit, offset ->
        delay(1000)
        val items = allItems.drop(offset).take(limit)
        items
    }
}

@Composable
fun BasicPagingScreen() {
    val viewModel: BasicPagingViewModel = provideViewModel()
    DsPagingList(
        pager = viewModel.pager,
        itemContent = {
            ItemBlock(item = it)
        }
    )
}

@Composable
private fun ItemBlock(item: String?) {
    DsText(text = item.orEmpty())
}
```