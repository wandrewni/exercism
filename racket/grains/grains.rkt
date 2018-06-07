#lang racket

(provide square total)

(define (square x) (expt 2 (- x 1)))
(define (inc x) (+ x 1))
(define (total)
  (define (sum term a next b)
    (if (> a b)
        0
        (+ (term a)
           (sum term (next a) next b))))
  (sum square 1 inc 64))