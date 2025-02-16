package kg.geeks.compose.ui.serviceLocator

import kg.geeks.compose.ui.app.viewModel.CharactersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
    viewModel { CharactersViewModel(get()) }
}