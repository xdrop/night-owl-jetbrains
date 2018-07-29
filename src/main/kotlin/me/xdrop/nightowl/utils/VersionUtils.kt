package me.xdrop.nightowl.utils

fun compareVersion(v1: String, v2: String) : Int {
    val version1parts = v1.split(".")
    val version2parts = v2.split(".")

    var i = 0

    // set index to first non-equal ordinal or length of shortest version string
    while (i < version1parts.size && i < version2parts.size && version1parts[i] == version2parts[i]) {
        i++
    }

    // compare first non-equal ordinal number
    if (i < version1parts.size && i < version2parts.size) {
        val diff = Integer.valueOf(version1parts[i]).compareTo(Integer.valueOf(version2parts[i]))
        return Integer.signum(diff)
    }

    // the strings are equal or one string is a substring of the other
    // e.g. "1.2.3" = "1.2.3" or "1.2.3" < "1.2.3.4"
    return Integer.signum(version1parts.size - version2parts.size)
}
