package com.example.clashroyaleapplication.data.mapper

interface BaseMapper<IN, OUT> {
    fun transform(entity: IN): OUT
}