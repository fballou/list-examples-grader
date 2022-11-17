# Create your grading script here

CPATH=".:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar"
# set -e

rm -rf student-submission
mkdir student-submission

git clone $1 student-submission

if test -f student-submission/ListExamples.java;
then
    echo "Files were found chief"
else
    echo "0 Tests Passed. Assignment Failed. Files Not Found"
    exit 39
fi


cp TestListExamples.java student-submission
cp -r lib student-submission
cd student-submission

javac ListExamples.java
if [[ $? != 0 ]]
then 
    echo "0 Tests Passed. Assignment Failed. ListExamples.java did not compile."
    exit 
else   
    echo "ListExamples.java Has Successfully Compiled."
fi

javac -cp $CPATH *.java

java -cp $CPATH org.junit.runner.JUnitCore TestListExamples
