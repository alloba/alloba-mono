import io.github.fstaudt.hugo.OsFamily

plugins {
    id("io.github.fstaudt.hugo") version "0.6.0"
}

hugo {
    version = "0.115.2" // Hugo version
    sourceDirectory = "site" // Relative path to sources of Hugo site in Gradle project

    windowsDownloadUrl = "https://github.com/gohugoio/hugo/releases/download/v{0}/hugo_extended_{0}_windows-amd64.zip"
    linuxDownloadUrl = "https://github.com/gohugoio/hugo/releases/download/v{0}/hugo_extended_{0}_linux-amd64.tar.gz"
    macOSDownloadUrl = "https://github.com/gohugoio/hugo/releases/download/v{0}/hugo_extended_{0}_darwin-universal.tar.gz"
    osFamily = getOS()
}

fun getOS(): OsFamily {
    val os = System.getProperty("os.name").lowercase()
    return when {
        os.contains("win") -> {
            OsFamily.WINDOWS
        }
        os.contains("nix") || os.contains("nux") || os.contains("aix") -> {
            OsFamily.UNIX
        }
        os.contains("mac") -> {
            OsFamily.MAC
        }
        else -> throw RuntimeException("Failed to detect operating system for Hugo Operation")
    }
}