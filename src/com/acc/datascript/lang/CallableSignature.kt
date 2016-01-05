package com.acc.datascript.lang

import com.acc.datascript.lang.psi.DsCallableCardinality
import com.acc.datascript.resources.ColumnType

/**
 * Created by demius on 29.12.2015.
 */
data class CallableSignature(val name: String, val cardinality: Int): Comparable<CallableSignature> {

    override fun compareTo(other: CallableSignature): Int {
        val i = name.compareTo(other.name)
        return if (i == 0) cardinality.compareTo(other.cardinality) else i
    }

}