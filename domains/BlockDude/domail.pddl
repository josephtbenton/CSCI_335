;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; BlockDude World
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(define (domain OFFICE)
  (:requirements :strips)
  (:predicates (above ?x ?y)
        (below ?x ?y)
        (leftof ?x ?y)
        (rightof ?x ?y)
        (ismovable ?x)
        (ischaracter ?x)
        (handempty)
        )


(:action pick-up
	     :parameters (?r ?x)
	     :precondition (and (inroom ?x ?r) (handempty) (roomhasbot ?r))
	     :effect
	     (and (not (inroom ?x ?r))
		   (not (handempty))
		   (holding ?x)))

 (:action put-down
	     :parameters (?x ?r)
	     :precondition (and (holding ?x) (roomhasbot ?r))
	     :effect
	     (and (not (holding ?x))
		   (handempty)
		   (inroom ?x ?r)))

 (:action move-to
	     :parameters (?a ?b)
	     :precondition (and (roomhasbot ?a) (adjacent ?a ?b))
	     :effect
	     (and
		   (not (roomhasbot ?a))
		   (roomhasbot ?b))))