# Create your grading script here

CPATH=".:/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar"
set -e

rm -rf student-submission
mkdir student-submission

git clone $1 student-submission

if [[-f student-submission/ListExamples.java]] 
then
    echo "Files were found chief"
else
    echo "Files were not found chief"
    exit 39
fi


cp TestListExamples.java student-submission
cp -r lib student-submission
cd student-submission

javac -cp $CPATH *.java

java -cp $CPATH org.junit.runner.JUnitCore TestListExamples
