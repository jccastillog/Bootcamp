mensaje= input()
numero = int(input())
cifrado=""
for letra in mensaje:
    if letra.isalpha():
        base = ord('a') if letra.islower()  else  ord('A')
        desplazamiento = (ord(letra) - base + numero) % 26
        nueva_letra = chr(base + desplazamiento)
        cifrado += nueva_letra
    else:
        cifrado += letra  
print (cifrado)