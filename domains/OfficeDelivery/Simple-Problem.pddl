(define (problem Simple-Problem)
(:domain OFFICE)
(:objects R1 R2 B)
(:init (roomhasbot R2) (handempty) (adjacent R1 R2) (adjacent R2 R1) (inroom B R1))
(:goal (inroom B R2)))