;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; GRID
;;; WORLD
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(define (domain BLOCKS)
  (:requirements :strips)
  (:predicates
;;; objects
  (bot ?x)
  (position ?x)
  (key ?x)
  (lock ?x)
;;; relationships
  (unlocks ?key ?lock)
  (unlocked ?lock)
  (at ?obj ?x ?y)
  (inc ?p ?pp)
  (dec ?p ?pp)
  (handempty ?bot)
  (has ?bot ?key)
    )

  (:action pick-up
        :parameters (?b ?px ?py ?k)
        :precondition (and
    		   (bot ?b) (position ?px) (position ?py) (key ?k)
    		   (at ?b ?px ?py) (at ?k ?px ?py) (handempty))
        :effect (and (not (at ?k ?px ?py))
    		 (not (handemtpy)) (has ?b ?k)))
  (:action unlock
        :parameters (?b ?px ?py ?k ?l)
        :precondition (and
                (bot ?b) (position ?px) (position ?py) (key ?k) (lock ?l)
                (at ?b ?px ?py) (at ?l ?px ?py) (has ?b ?k) (unlocks ?k ?l))
        :effect (and
                (unlocked ?l) (not (has ?b ?k)) (handempty)))
  (:action move-up
      :parameters (?b ?px ?py ?by)
      :precondition (and
  		   (bot ?b) (position ?px) (position ?py) (position ?by)
  		   (dec ?by ?py) (at ?b ?px ?py))
      :effect (and (not (at ?b ?px ?py))
  		 (at ?b ?px ?by)))
    (:action move-down
      :parameters (?b ?px ?py ?by)
      :precondition (and
  		   (bot ?b) (position ?px) (position ?py) (position ?by)
  		   (inc ?by ?py) (at ?b ?px ?py))
      :effect (and (not (at ?b ?px ?py))
  		 (at ?b ?px ?by)))
    (:action move-left
      :parameters (?b ?px ?py ?bx)
      :precondition (and
  		   (bot ?b) (position ?px) (position ?py) (position ?bx)
  		   (dec ?bx ?px) (at ?b ?px ?py))
      :effect (and (not (at ?b ?px ?py))
  		 (at ?b ?bx ?py)))
    (:action move-right
      :parameters (?b ?px ?py ?bx)
      :precondition (and
  		   (bot ?t) (position ?px) (position ?py) (position ?bx)
  		   (inc ?bx ?px) (at ?b ?px ?py))
      :effect (and (not (at ?t ?px ?py))
  		 (at ?t ?bx ?py)))
    )