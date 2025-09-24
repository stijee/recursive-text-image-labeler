
# Project1: Connected Components Labeling

## Overview

This Java program reads one or more images from standard input, labels all connected components of `*` pixels using 4-way connectivity, and outputs the labeled images along with a summary of component sizes.

## How to Compile

```sh
javac Project1.java
```

## How to Run

You can run the program and provide input via a file (e.g., `input.txt`):

```sh
java Project1 < input.txt
```

Or, you can run and enter input manually:

```sh
java Project1
```
Then type or paste your input, followed by Enter.

## Input Format

- The first line contains an integer `n`, the number of images.
- For each image:
	- The first line contains two integers: number of rows `r` and columns `c`.
	- The next `r` lines each contain a string of `c` characters (`*` for a pixel, `.` for empty).

Example (`input.txt`):

```
2
3 3
*..
.**
*..

8 10
.........*
...**....*
..........
....*..*..
...*...*..
.......**.
....**....
..........
```

## Output

For each image:
- The labeled image is printed, with each connected component of `*` replaced by a unique letter (`a`, `b`, ...).
- Then, for each unique component size, a line with the size and the number of components of that size.
- A blank line separates outputs for each image.

## Example Output

```
a..
.bc
a..

1 1
2 1

...
```


## Notes

- Only `.java` source files and input files are included in this repository.
- Compiled files (`.class`), archives (`.zip`), and system files are excluded via `.gitignore`.

## TODO

- Add a graphical user interface (GUI) so the program can be used as a desktop application, not just in the terminal.
- Allow users to load images and view labeled results visually.
- Add options for saving output images or results.
