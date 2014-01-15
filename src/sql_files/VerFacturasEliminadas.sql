SELECT F.Fecha ,Per.`Nombre` AS Cliente,F.idFactura AS NumFact,
SUM(PCF.`Cantidad`) AS TotalItem,F.Descuento,
(F.TotalFacturado+F.Descuento) AS SubTotal,F.TotalFacturado
FROM Factura AS F, productocantidadfact AS PCF, persona AS Per
WHERE F.Fecha BETWEEN ? AND ? AND 
PCF.`idFactura`=F.`idFactura` AND F.`idCliente`=Per.`idPersona` 
AND F.`Concepto`="Eliminada" AND F.`Estado`= "I"
 AND F.`idVersionFactura` = PCF.`idVersionFacturasProducto`
GROUP BY F.idFactura;
