# CMAKE generated file: DO NOT EDIT!
# Generated by "MinGW Makefiles" Generator, CMake Version 3.15

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

SHELL = cmd.exe

# The CMake executable.
CMAKE_COMMAND = "C:\Program Files\JetBrains\CLion 2019.2.5\bin\cmake\win\bin\cmake.exe"

# The command to remove a file.
RM = "C:\Program Files\JetBrains\CLion 2019.2.5\bin\cmake\win\bin\cmake.exe" -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = C:\Progr\T32HUFF

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = C:\Progr\T32HUFF\cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/T32HUFF.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/T32HUFF.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/T32HUFF.dir/flags.make

CMakeFiles/T32HUFF.dir/HUFF.C.obj: CMakeFiles/T32HUFF.dir/flags.make
CMakeFiles/T32HUFF.dir/HUFF.C.obj: CMakeFiles/T32HUFF.dir/includes_CXX.rsp
CMakeFiles/T32HUFF.dir/HUFF.C.obj: ../HUFF.C
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=C:\Progr\T32HUFF\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/T32HUFF.dir/HUFF.C.obj"
	C:\MinGW\bin\g++.exe  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles\T32HUFF.dir\HUFF.C.obj -c C:\Progr\T32HUFF\HUFF.C

CMakeFiles/T32HUFF.dir/HUFF.C.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/T32HUFF.dir/HUFF.C.i"
	C:\MinGW\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E C:\Progr\T32HUFF\HUFF.C > CMakeFiles\T32HUFF.dir\HUFF.C.i

CMakeFiles/T32HUFF.dir/HUFF.C.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/T32HUFF.dir/HUFF.C.s"
	C:\MinGW\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S C:\Progr\T32HUFF\HUFF.C -o CMakeFiles\T32HUFF.dir\HUFF.C.s

CMakeFiles/T32HUFF.dir/T32HUFF.C.obj: CMakeFiles/T32HUFF.dir/flags.make
CMakeFiles/T32HUFF.dir/T32HUFF.C.obj: CMakeFiles/T32HUFF.dir/includes_CXX.rsp
CMakeFiles/T32HUFF.dir/T32HUFF.C.obj: ../T32HUFF.C
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=C:\Progr\T32HUFF\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Building CXX object CMakeFiles/T32HUFF.dir/T32HUFF.C.obj"
	C:\MinGW\bin\g++.exe  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles\T32HUFF.dir\T32HUFF.C.obj -c C:\Progr\T32HUFF\T32HUFF.C

CMakeFiles/T32HUFF.dir/T32HUFF.C.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/T32HUFF.dir/T32HUFF.C.i"
	C:\MinGW\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E C:\Progr\T32HUFF\T32HUFF.C > CMakeFiles\T32HUFF.dir\T32HUFF.C.i

CMakeFiles/T32HUFF.dir/T32HUFF.C.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/T32HUFF.dir/T32HUFF.C.s"
	C:\MinGW\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S C:\Progr\T32HUFF\T32HUFF.C -o CMakeFiles\T32HUFF.dir\T32HUFF.C.s

# Object files for target T32HUFF
T32HUFF_OBJECTS = \
"CMakeFiles/T32HUFF.dir/HUFF.C.obj" \
"CMakeFiles/T32HUFF.dir/T32HUFF.C.obj"

# External object files for target T32HUFF
T32HUFF_EXTERNAL_OBJECTS =

T32HUFF.exe: CMakeFiles/T32HUFF.dir/HUFF.C.obj
T32HUFF.exe: CMakeFiles/T32HUFF.dir/T32HUFF.C.obj
T32HUFF.exe: CMakeFiles/T32HUFF.dir/build.make
T32HUFF.exe: CMakeFiles/T32HUFF.dir/linklibs.rsp
T32HUFF.exe: CMakeFiles/T32HUFF.dir/objects1.rsp
T32HUFF.exe: CMakeFiles/T32HUFF.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=C:\Progr\T32HUFF\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_3) "Linking CXX executable T32HUFF.exe"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles\T32HUFF.dir\link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/T32HUFF.dir/build: T32HUFF.exe

.PHONY : CMakeFiles/T32HUFF.dir/build

CMakeFiles/T32HUFF.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles\T32HUFF.dir\cmake_clean.cmake
.PHONY : CMakeFiles/T32HUFF.dir/clean

CMakeFiles/T32HUFF.dir/depend:
	$(CMAKE_COMMAND) -E cmake_depends "MinGW Makefiles" C:\Progr\T32HUFF C:\Progr\T32HUFF C:\Progr\T32HUFF\cmake-build-debug C:\Progr\T32HUFF\cmake-build-debug C:\Progr\T32HUFF\cmake-build-debug\CMakeFiles\T32HUFF.dir\DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/T32HUFF.dir/depend
