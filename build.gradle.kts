// Top-level build file where you can add configuration options common to all sub-projects/modules.


buildscript {
    extra.apply {
        set("compose_bom", "2023.04.01")
    }
}

plugins {
    id("com.android.application") version "8.1.1" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
    id("com.android.library") version "8.1.1" apply false
}

