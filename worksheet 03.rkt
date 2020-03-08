;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname |worksheet 03|) (read-case-sensitive #t) (teachpacks ((lib "image.rkt" "teachpack" "2htdp"))) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ((lib "image.rkt" "teachpack" "2htdp")) #f)))
;; Question 1
;;"helloworld"
;;counting from 1-5
(string-append "hello""_""world")


;;Question 2
(circle 100 "solid" "red")
(place-image(circle 100 "solid" "red")10 40(rectangle 300 400 "solid" "green"))
(empty-scene 200 200)
(place-image(circle 100 "solid" "red")10 40(empty-scene 200 200))

;;Question 3
(empty-scene 100 100)
(place-image(triangle 40 "outline" "blue")50 30
(place-image(rectangle 40 40  "solid" "blue")50 69(empty-scene 100 100)))

;;Question 4
(circle 100 "solid" "green")