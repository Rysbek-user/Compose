package kg.geeks.compose.ui.app

import android.app.Application
import kg.geeks.compose.ui.data.serviceLocator.dataModule
import kg.geeks.compose.ui.modul.appModule
import kg.geeks.compose.ui.modul.uiModule
import org.koin.core.context.GlobalContext.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(dataModule, uiModule, appModule)
        }
    }
}