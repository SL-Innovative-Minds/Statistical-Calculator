# Statistical-Calculator

# Project Introduction:
  This project is for designing an application using Java programming language to calculate statical values such as mean, median & variance by using user given data set.  The application is also able to implement search function to find the index of a specific data.

  All the functions are derived by proper implementation of the Data Structures & Algorithms theories and techniques.
  
# Theories used:
When creating this application, following algorithms and data structures were used.

  Merge sort:
  Sorting algorithm which is used to sort some data values in given data structure according to the specific order.

  Expression tree:
  A non-linear data structure and a kind of a tree to store some data values and do their calculations according to the given order.

  Binary search (expected to use):
  A searching algorithm to search some specified value position from given data set.

# Requirements Specification 
After proposal submitting whole team members spent two weeks to follow both online and offline resources related the theoretical knowledge on the algorithms and data structures those used in the project.

Another week was spent to get a vast idea about how to manipulate and organize a data set statically, learn static formulas and how to use them.

After having vast knowledge through these learnings whole team suggest following requirements as project requirements.

Requirements

    1.  We need an application to analyze the given data set.
    2.  It can be used to calculate mean, median, variance.
    3.  When we enter a new data, the values should be automatically recalculated.
    4.  The sorted data set should appear in this application.
    5.  The position (in the Array List) of a particular value in the dataset should be given    when requested.

As non-functional requirements, team decided to create a simple and user-friendly single interface application.

# Designing and implementation
   For the ‘Front-end development’, the application interface have following characteristics.
  Interface should have

    1.	Data entering text field - to write new data
    2.	‘Add’ button - to insert the data
    3.	‘Clear’ button - to clear the text fields and the data in all variables
    4.	‘Undo’ button - to retract a data entry
    5.	Labels to show values - all calculated values should show there
    6.	Sorted data list- data should be re-sorting each time data enter and show it in different text area
    7.	A text field for enter a value to find if it is in the data set
    8.	A label to get the position of the searched value
    
Individual contributions are shown below.

    •	Implement Expression Tree
    •	Implement Merge Sort
    •	Implement Binary Search code
    •	Get data values and manipulate data array
    •	Calculating mean by expression tree
    •	Sorting data set and calculating median
    •	Calculating Variance
    •	Exception handling
    •	Create GUI and button functions 
    
# Validation and testing 
Checked test cases

When Pressed ‘Add’ button

    •	Entered data has to be a real number
    •	If entered value is letter/ white space, it should give an error
    •	Value entered as double value should be entered to the string array list
    •	Sorted array should be updated
    •	All values should round up to 2 digits

When pressed ‘Clear’ button

    •	Edit texts, label and stored data should come to the initial state.
    When pressed ‘Undo’ button
    •	Last data entry should remove from the Array List and re-do the calculation and show the values in text fields for the if the Array List is not empty after  performing ‘remove’.
    When pressed ‘Try’ button
    •	Check if a real number is entered in the text field for the Binary Search.  If it is found if the value is in the sorted array list and output the index of it.
    Integrating and evolution - (done as whole team)



