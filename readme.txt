<!--VARIABLES {"title": "About the course", "SORT_ORDER": "010", "code": "about"}-->

[TOC]

[1]: <!--page refs-->#ref_1
[1.1]: <!--page refs-->#ref_1_1
[2]: <!--page refs-->#ref_2

----------------------------------------------------------------------------------------------------
Mar 17, 2023 --- Apr 6, 2023

# About this course

This course consists of the following parts:

- [Beginner](<!--page about_part_1-->), the material is [[1][]];
- [Intermediate](<!--page about_part_2-->), the material is [[2][]].

Its main goal is understanding the basic concepts of Java web application and practical steps for
setting up and adjustment of a web application using Spring MVC framework.

----------------------------------------------------------------------------------------------------
<!--index ["Spring Boot"]-->
# Why not Spring Boot?

[[1.1][]], [6:01](https://youtu.be/zCHrZdJODg4?t=361)

Spring Boot does a lot of things to ease our web application creation, but what it actually does
is helping us to wrap all Spring components in a convenient way. So Spring Boot wraps Spring MVC
and that's why knowledge about Spring MVC is required to **understand** Spring Boot.

----------------------------------------------------------------------------------------------------
# Notes writing

## Patch pages generation

The following Python script (called `gitDiff2Html.py`) may be used for that:

````code
from html import escape

def styled_line(string, css_class=None):
    if css_class:
        return '<span class="' + css_class + '">' + string + '</span><br />\n'
    else:
        return '<span>' + string + '</span><br />\n'
    
print('<div class="patch_block">\n')

while True:
    try:
        line = input()
    except EOFError:
        break
    escaped_line = escape(line)
    if line[:4] == 'diff':
        print(styled_line(escaped_line, "diff"))
    elif line[:5] == 'index':
        print(styled_line(escaped_line, "index"))
    elif line[:3] == '---':
        print(styled_line(escaped_line, "tree_minuses"))
    elif line[:3] == '+++':
        print(styled_line(escaped_line, "tree_pluses"))
    elif line[:2] == '@@':
        print(styled_line(escaped_line, "two_ats"))
    elif line[:1] == '+':
        print('<ins>' + escaped_line + '</ins><br />\n')
    elif line[:1] == '-':
        print('<del>' + escaped_line + '</del><br />\n')
    else:
        print(styled_line(escaped_line))
        
print('</div>\n')
````

Need to add the environment variable `GIT_DIFF_2_HTML_HOME` pointing to the directory where this
Python file resides.

The batch file `generate_patch.bat` may be used for converting `git diff` output to HTML like this:

````shell
generate_patch.bat 236fe6a16456e9d45e935d6849e5adb8bb1eb7e8
````




