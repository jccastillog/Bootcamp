ct_actual, ct_compra, ct_ventas, ct_maxalm, ct_limvta, ct_umbdct = map(float, input().split())

if ct_compra > ct_umbdct :
    ct_compra = (ct_compra*.9)

if ct_compra < ct_maxalm * .2:
    ct_compra = 0

ventas_posibles = ct_actual*(ct_limvta/100)

if ct_ventas > ventas_posibles:
    ct_ventas = ventas_posibles

if ct_actual < ct_maxalm * .3:
    ct_ventas=min(ct_ventas,ct_actual*.5)

nuevo_saldo = ct_actual+ct_compra-ct_ventas


print (nuevo_saldo) 
