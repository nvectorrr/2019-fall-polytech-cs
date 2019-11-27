cmake_minimum_required(VERSION 3.15)
project(T32EXPR C)

set(CMAKE_C_STANDARD 11)

include_directories(.)

add_executable(T32EXPR
        EVAL.c
        EXPR.h
        LISTS.c
        PARSER.c
        SCANNER.c
        T32EXPR.c
        VARTAB.c)
