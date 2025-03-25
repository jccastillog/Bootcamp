SELECT l.Titulo, a.Nombre AS Autor, COUNT(DISTINCT p.usuarioID) AS TotalUsuariosDiferentes 
FROM Libros l 
JOIN Prestamos p ON (P.LibroID = l.IDLibro) 
JOIN Autores a ON (a.IDAutor = l.AutorID) 
WHERE l.IDLibro IN (SELECT DISTINCT LibroID from Prestamos) 
AND a.IDAutor IN (SELECT AutorID from Libros GROUP BY AutorID HAVING (COUNT(IDLibro)>1))
GROUP BY l.Titulo, a.Nombre

