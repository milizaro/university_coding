package Enums

import classes.{Student, Subject, Teacher, Token}

var SUBJECT_LIST: List[Subject] = List(
  new Subject("Math"),
  new Subject("Chemistry"),
  new Subject("Physics"),
  new Subject("Philosophy"),
  new Subject("Literature"),
  new Subject("Programming"))

var STUDENT_LIST: List[Student] = List(
  new Student(20, "std1", "Address", "100", new Token(50, "Test")),
  new Student(25, "std2", "Address", "120", new Token(50, "Test")),
  new Student(29, "std3", "Address", "132", new Token(50, "Test")),
  new Student(30, "std4", "Address", "55", new Token(50, "Test")),
  new Student(24, "std5", "Address", "202", new Token(50, "Test")),
  new Student(38, "std6", "Address", "531", new Token(50, "Test")),
)

var TEACHER_LIST: List[Teacher] = List(
  new Teacher(35, "teacher1", "Address"),
  new Teacher(29, "teacher2", "Address"),
  new Teacher(42, "teacher3", "Address"),
  new Teacher(34, "teacher4", "Address"),
  new Teacher(34, "teacher5", "Address"),
  new Teacher(35, "teacher6", "Address"),
)