cmake_minimum_required(VERSION 3.15)
project(T32HUFF)

set(CMAKE_CXX_STANDARD 14)

include_directories(.)

add_executable(T32HUFF
        HUFF.C
        HUFF.H
        T32HUFF.C)
