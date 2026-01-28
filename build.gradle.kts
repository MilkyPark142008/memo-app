// 顶层构建脚本配置
plugins {
    id("com.android.application") version "8.3.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.20" apply false
}

// 清理任务
tasks.register("clean", Delete::class) {
    delete(rootProject.layout.buildDirectory)
}
