package app.di.state

import app.showcases.ShowcasesDestination
import app.ui.screen.template.TemplateDestination
import app.ui.screen.template_no_args.TemplateNoArgsDestination
import app.userflow.theme.change.ChangeThemeDestination
import app.userflow.theme.change.ChangeThemeDialogDestination
import core.ui.navigation.NavigationState
import org.koin.dsl.module

val ProvidesNavigationState = module {
    single {
        NavigationState(
            destinations = listOf(
                ShowcasesDestination,
                TemplateDestination,
                TemplateNoArgsDestination,
                ChangeThemeDestination,
                ChangeThemeDialogDestination
            )
        )
    }
}