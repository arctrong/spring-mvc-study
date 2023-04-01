@echo off

if [%1]==[] (
    echo Commit hash is not specified
    pause
    exit /b
)

set OUT=doc_src\patches\%1.txt

echo ^<!--VARIABLES {"title": "Patch %1"}--^> > %OUT%

git diff %1^^! | python "%GIT_DIFF_2_HTML_HOME%\gitDiff2Html.py" >> %OUT%
