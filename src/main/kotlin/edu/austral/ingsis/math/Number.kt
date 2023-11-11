package edu.austral.ingsis.math

class Number(private val value: Double):Function {
    override fun getValue(variableMap: Map<String, Double>): Double {
        return value
    }

    override fun getString(): String {
        return value.toInt().toString()
    }

    override fun getVariables(variables: List<String>): List<String> {
        return variables;
    }

}