package com.acc.datascript.utils

import java.util.function.Consumer

/**
 * Created by demius on 04.01.2016.
 */

public fun <T> join(list: Iterable<T>, sb: StringBuilder, separator: String?, transformer: Consumer<T>?) {
    var count = 0
    for (element in list) {
        if (count > 0 && separator != null) sb.append(separator)

        if (transformer == null)
            sb.append(element)
        else
            transformer.accept(element)

        count++
    }
}

public fun <T> join(list: Iterable<T>, sb: StringBuilder, separator: String? = null, before: String? = null, after: String? = null, transformer: ((T) -> Unit)? = null) {
    var count = 0
    for (element in list) {
        if (count == 0) {
            if (before != null) sb.append(before)
        } else if (separator != null) sb.append(separator)

        if (transformer == null)
            sb.append(element)
        else
            transformer.invoke(element)

        count++
    }
    if (count > 0 && after != null) sb.append(after)
}

public fun <T> join(list: Array<out T>, sb: StringBuilder, separator: String? = null, before: String? = null, after: String? = null, transformer: ((T) -> Unit)? = null) {
    var count = 0
    for (element in list) {
        if (count == 0) {
            if (before != null) sb.append(before)
        } else if (separator != null) sb.append(separator)

        if (transformer == null)
            sb.append(element)
        else
            transformer.invoke(element)

        count++
    }
    if (count > 0 && after != null) sb.append(after)
}

