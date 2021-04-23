object Dependencies {

    const val kotlinVersion=  "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinVersion}"
    const val coreKtx=  "androidx.core:core-ktx:${Versions.coreKtx}"
    const val appcompat=  "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val material=  "com.google.android.material:material:${Versions.material}"
    const val constraintlayout=  "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}"
    const val legacySupportV4 =  "androidx.legacy:legacy-support-v4:${Versions.legacySupportV4}"

    //NAVIGATION
    const val navVersion=  "androidx.navigation:navigation-fragment-ktx:${Versions.navVersion}"
    const val navVersionKtx=  "androidx.navigation:navigation-ui-ktx:${Versions.navVersion}"

    //RETROFIT
    const val retrofitVersion=  "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    const val retrofitConverterGson=  "com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}"
    const val retrofitRxJava2=  "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofitVersion}"

    //RXJAVA
    const val rxJavaVersion=  "io.reactivex.rxjava2:rxjava:${Versions.rxJavaVersion}"
    const val rxAndroid=  "io.reactivex.rxjava2:rxandroid:${Versions.rxJavaVersion}"

    //LIFECYCLE
    const val lifecycleExtVersion=  "android.arch.lifecycle:extensions:${Versions.lifecycleExtVersion}"

    //PAGING
    const val pagingRunTimeKtx=  "androidx.paging:paging-runtime-ktx:${Versions.pagingVersion}"
    const val pagingRxJava2Ktx=  "androidx.paging:paging-rxjava2-ktx:${Versions.pagingVersion}"

    //GLIDE
    const val glideVersion=  "com.github.bumptech.glide:glide:${Versions.glideVersion}"

    //HILT
    const val daggerHilt = "com.google.dagger:hilt-android:${Versions.daggerHiltVersion}"
    const val daggerHiltCompiler = "com.google.dagger:hilt-compiler:${Versions.daggerHiltVersion}"
    const val hiltLifecycleViewModel =  "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hiltLifecycleViewmodel}"
}