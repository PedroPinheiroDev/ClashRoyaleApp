package com.example.clashroyaleapplication.data.mapper

interface BaseMapper<IN, OUT> {
    operator fun invoke(entity: IN): OUT
}