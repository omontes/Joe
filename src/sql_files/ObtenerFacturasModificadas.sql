SELECT F.Fecha ,F.idFactura AS NumFact,F.`idVersionFactura`,C.`Nombre` AS Cliente,
V.Nombre AS Vendedor,F.Descuento,((F.`TotalTarjeta`+F.`TotalContado`) / (1 - ((F.Descuento) / 100))) AS SubTotal,
(F.`TotalTarjeta`+F.`TotalContado`) AS TotalFacturado,F.`Nota`
FROM Factura AS F, Productocantidadfact AS PCF, Persona AS C, Persona AS V
WHERE F.`idFactura` = ? AND F.`idCliente`=C.`idPersona` AND 
F.`idVendedor` = V.`idPersona`
AND F.`idVersionFactura` = PCF.`idVersionFacturasProducto` AND F.`idFactura` NOT IN(SELECT FP.`idFactura` FROM facturaspendientes AS FP)
GROUP BY F.`idVersionFactura`


UNION


SELECT F.Fecha ,F.idFactura AS NumFact,F.`idVersionFactura`,C.`Nombre` AS Cliente,
V.Nombre AS Vendedor,F.Descuento,((F.`TotalTarjeta`+F.`TotalContado`+FP.`Saldo`) / (1 - ((F.Descuento) / 100))) AS SubTotal,
(F.`TotalTarjeta`+F.`TotalContado`+FP.`Saldo`) AS TotalFacturado,F.`Nota`
FROM Factura AS F, Productocantidadfact AS PCF, Persona AS C, Persona AS V, facturaspendientes AS FP
WHERE F.`idFactura` = ? AND F.`idCliente`=C.`idPersona` AND 
F.`idVendedor` = V.`idPersona`
AND F.`idVersionFactura` = PCF.`idVersionFacturasProducto` AND FP.`idFactura` = F.`idFactura` AND FP.`idVersionFactPendientes` = F.`idVersionFactura`

GROUP BY F.`idVersionFactura`



;