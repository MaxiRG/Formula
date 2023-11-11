package edu.austral.ingsis.math

interface Function {
    fun getValue(variableMap: Map<String, Double>):Double
    fun getString():String

    fun getVariables(variables: List<String>):List<String>
}