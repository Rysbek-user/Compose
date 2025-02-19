package kg.geeks.compose.ui.modul

import kg.geeks.compose.ui.viewModule.CharacterViewModule
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
    viewModel { CharacterViewModule(get()) }
}