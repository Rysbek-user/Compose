package kg.geeks.compose.ui.modul

import kg.geeks.compose.ui.data.api.CharacterApiService
import kg.geeks.compose.ui.data.api.EpisodeApiService
import kg.geeks.compose.ui.data.api.LocationApiService
import kg.geeks.compose.ui.data.repository.CharacterRepasitory
import kg.geeks.compose.ui.data.repository.EpisodeRepository
import kg.geeks.compose.ui.data.repository.FavoriteCharacterRepository
import kg.geeks.compose.ui.data.repository.LocationRepository
import kg.geeks.compose.ui.viewModule.CharacterViewModule
import kg.geeks.compose.ui.viewModule.EpisodeViewModel
import kg.geeks.compose.ui.viewModule.FavoriteCharacterViewModel
import kg.geeks.compose.ui.viewModule.LocationViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val appModule = module {


    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY

    val client = OkHttpClient.Builder()
        .connectTimeout(10, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.SECONDS)
        .callTimeout(20, TimeUnit.SECONDS)
        .writeTimeout(20, TimeUnit.SECONDS)
        .addInterceptor(interceptor)
        .build()

    single {
        Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }




    single { get<Retrofit>().create(CharacterApiService::class.java) }
    single { get<Retrofit>().create(EpisodeApiService::class.java) }
    single { get<Retrofit>().create(LocationApiService::class.java) }

    single { CharacterRepasitory(get()) }
    single { EpisodeRepository(get()) }
    single { LocationRepository(get()) }
    single { FavoriteCharacterRepository(get()) }
    single { FavoriteCharacterRepository(get()) }
    //single { FavoriteCharacterDao(get()) }

    viewModel { CharacterViewModule(get()) }
    viewModel { EpisodeViewModel(get()) }
    viewModel { LocationViewModel(get()) }
    viewModel { FavoriteCharacterViewModel(get()) }
}