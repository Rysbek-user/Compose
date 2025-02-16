package kg.geeks.compose.ui.app

import android.app.Application
import kg.geeks.compose.ui.data.serviceLocator.dataModul
import kg.geeks.compose.ui.serviceLocator.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(dataModul, uiModule)
        }
    }
}