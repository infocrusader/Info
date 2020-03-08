;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname |worksheet 07|) (read-case-sensitive #t) (teachpacks ((lib "image.rkt" "teachpack" "2htdp") (lib "universe.rkt" "teachpack" "2htdp") (lib "batch-io.rkt" "teachpack" "2htdp") (lib "gui.rkt" "teachpack" "htdp"))) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ((lib "image.rkt" "teachpack" "2htdp") (lib "universe.rkt" "teachpack" "2htdp") (lib "batch-io.rkt" "teachpack" "2htdp") (lib "gui.rkt" "teachpack" "htdp")) #f)))
;;Question 1
;;Contract:number→number

(define (countDigit lst)
      (cond
       [(empty? lst) 0]
       [else (+ 1 (countDigit (rest lst)))]))

(countDigit (list 1 2 3))
(countDigit (list 6 4 1 0 9))

;;Questtion 2
;;contract:number→number

(define (sumDigit L)
  (if (empty? L) 0
      (+ (first L) (sumDigit (rest L)))))

(sumDigit (list 1 2 3 4))
(sumDigit (list 6 4 1 0 9))