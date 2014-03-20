SELECT F.Fecha ,F.idFactura AS NumFact,F.`idVersionFactura`,C.`Nombre` AS Cliente,
V.Nombre AS Vendedor,F.Descuento,((F.`TotalTarjeta`+F.`TotalContado`) / (1 - ((F.Descuento) / 100))) AS SubTotal,
(F.`TotalTarjeta`+F.`TotalContado`) AS TotalFacturado,"",F.`Nota`
FROM Factura AS F, Productocantidadfact AS PCF, Persona AS C, Persona AS V
WHERE F.`idFactura` = ? AND F.`idCliente`=C.`idPersona` AND 
F.`idVendedor` = V.`idPersona`
AND F.`idVersionFactura` = PCF.`idVersionFacturasProducto`
GROUP BY F.`idVersionFactura`
ORDER BY F.`idVersionFactura` DESC;