;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; 4 Op-office world
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(define (domain OFFICE)
  (:requirements :strips)
  (:predicates (inroom ?x ?r)
        (roomhasbot ?r)
        (adjacent ?x ?y)
        (handempty)
        (holding ?x)
        )


(:action pick-up
	     :parameters (?r ?x)
	     :precondition (and (inroom ?x ?r) (handempty) (roomhasbot ?r))
	     :effect
	     (and (not (inroom ?x ?r))
		   (not (handempty))
		   (holding ?x)))

 (:action put-down
	     :parameters (?r ?x)
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