plugins {
    //trick: for the same plugin versions in all sub-modules
    id("com.android.library").version("8.1.1").apply(false)
    kotlin("multiplatform").version("1.8.21").apply(false)

}
//group = "org.jetbrains.base64"


tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
