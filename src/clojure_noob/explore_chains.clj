
;============================
; pigpen chains practice
;============================


 (->>
   (range -5 6))


 (->>
   (range -5 6)
   (filter pos?))

 (->>
   (range -5 6)
   (filter pos?)
   (map inc))

 (->>
   (range -5 6)
   (filter pos?)
   (map inc)
   (map str))
