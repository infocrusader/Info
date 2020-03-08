;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname |worksheet 06|) (read-case-sensitive #t) (teachpacks ((lib "image.rkt" "teachpack" "2htdp") (lib "universe.rkt" "teachpack" "2htdp") (lib "batch-io.rkt" "teachpack" "2htdp") (lib "gui.rkt" "teachpack" "htdp"))) (htdp-settings #(#t constructor repeating-decimal #f #t none #f ((lib "image.rkt" "teachpack" "2htdp") (lib "universe.rkt" "teachpack" "2htdp") (lib "batch-io.rkt" "teachpack" "2htdp") (lib "gui.rkt" "teachpack" "htdp")) #f)))
;;Question 1
;;contract:number(month)--->String

(check-expect (FindMonth 4) "spring")
(check-expect (FindMonth 9) "fall")

(define (FindMonth x)
  (cond
    ((and (<= x 0)(> x 12)) (error "invalid"))
    ((and (>= x 3)(<= x 5)) "spring")
    ((and (>= x 6)(<= x 8)) "summer")
    ((and (>= x 9)(<= x 11)) "fall")
    (else "winter")))

;;Question 2
;;contract:sumNtoM number number--->number

(check-expect (SumNM 4 7) 22)
(check-expect (SumNM 3 6) 18)

(define (SumNM x y)
  (cond
    ((and (= y y)(= x x)) (+ y x (+ (- y 1) (- y 2))))))

;;Question 3
;;contract:concatString:  String number→ string



    
    

