SELECT (F.`TotalTarjeta`+F.`TotalContado`) As TotalFacturado
FROM Factura AS F, productocantidadfact AS PCF
WHERE SUBSTRING(F.Fecha,1,10) BETWEEN ? AND ? AND 
PCF.`idFactura`=F.`idFactura` AND F.`Concepto`="Cancelada" AND F.`Estado`= "A" 
AND F.`idVersionFactura` = PCF.`idVersionFacturasProducto`;
