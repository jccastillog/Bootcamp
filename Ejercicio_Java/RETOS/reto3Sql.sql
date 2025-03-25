SELECT p.NombreProducto, c.Nombre AS NombreCliente, MAX(v.Cantidad) AS Cantidad 
FROM Ventas v 
JOIN Productos p ON v.IDProducto = p.IDProducto 
JOIN Clientes c ON v.IDCliente  = c.IDCliente  
GROUP BY p.NombreProducto, c.Nombre 
HAVING v.Cantidad = (SELECT MAX(v2.Cantidad) FROM Ventas v2 WHERE v2.IDProducto = v.IDProducto) 
ORDER BY v.IDProducto;

SELECT p.NombreProducto, c.Ciudad, SUM(v.cantidad) AS CantidadTotal, SUM(v.cantidad * p.Precio) AS PrecioTotal 
FROM Ventas v 
JOIN Productos p ON v.IDProducto = p.IDProducto 
JOIN Clientes c ON v.IDCliente  = c.IDCliente  
GROUP BY p.NombreProducto, c.Ciudad 
ORDER BY CantidadTotal DESC;

SELECT FechaVenta, COUNT(*) AS VentasRealizadas 
FROM Ventas 
GROUP BY FechaVenta 
ORDER BY VentasRealizadas DESC;

