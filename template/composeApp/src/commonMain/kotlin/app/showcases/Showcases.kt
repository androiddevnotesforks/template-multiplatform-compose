package app.showcases

import app.showcases.datasource.http.basic.BasicHttpShowcase
import app.showcases.datasource.keyvalue.`object`.ObjectKeyValueShowcase
import app.showcases.datasource.keyvalue.primitive.PrimitiveKeyValueShowcase
import app.showcases.datasource.paging.basic.BasicPagingShowcase
import app.showcases.navigation.args.ArgsNavigationShowcase
import app.showcases.navigation.no_args.NoArgsNavigationShowcase
import app.showcases.userflow.loader.data.DataLoaderShowcase
import app.showcases.userflow.theme.change.ChangeThemeDialogShowcase
import app.showcases.userflow.theme.change.ChangeThemeScreenShowcase
import app.showcases.userflow.theme.toggle.ToggleThemeShowcase

/**
 * Object containing all showcase items.
 */
object Showcases {

    /**
     * A list containing all showcase items.
     */
    val all = listOf(
        ShowcaseItemGroup("Navigation + MVVM"),
        NoArgsNavigationShowcase,
        ArgsNavigationShowcase,
        ShowcaseItemGroup("Datasource :: Http"),
        BasicHttpShowcase,
        ShowcaseItemGroup("Datasource :: KeyValue"),
        PrimitiveKeyValueShowcase,
        ObjectKeyValueShowcase,
        ShowcaseItemGroup("Datasource :: Paging"),
        BasicPagingShowcase,
        ShowcaseItemGroup("Userflow :: Loader"),
        DataLoaderShowcase,
        ShowcaseItemGroup("Userflow :: Theme"),
        ChangeThemeScreenShowcase,
        ChangeThemeDialogShowcase,
        ToggleThemeShowcase
    )

}