SELECT F.Fecha,F.`idFactura` AS NumFactura, F.Nota AS Descripcion ,
COUNT(PCF.`idProductoCantidadFact`) AS TotalItem,F.`Descuento`,
(F.`TotalFacturado`+F.`Descuento`) AS SubTotal,F.TotalFacturado 
FROM factura AS F, productocantidadfact AS PCF, persona AS C
WHERE F.idCliente=C.`idPersona` AND PCF.`idFactura` = F.`idFactura` 
AND C.`Nombre` = ? AND F.Fecha BETWEEN ? AND ?
GROUP BY F.`idFactura`;