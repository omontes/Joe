SELECT F.Fecha ,Per.`Nombre` AS Cliente,F.idFactura AS NumFact,
SUM(PCF.`Cantidad`) AS TotalItem,F.Descuento,
((F.`TotalTarjeta`+F.`TotalContado`) / (1 - ((F.Descuento) / 100))) AS SubTotal,(F.`TotalTarjeta`+F.`TotalContado`) AS TotalFacturado
FROM Factura AS F, productocantidadfact AS PCF, persona AS Per
WHERE SUBSTRING(F.Fecha,1,10) BETWEEN ? AND ? AND PCF.`idFactura`=F.`idFactura` AND F.`idCliente`=Per.`idPersona` 
AND F.`Concepto`!="Devolucion" AND F.`Concepto`!="Modificada" AND F.`Estado`= "I" AND F.`Concepto`="Cancelada"
 AND F.`idVersionFactura` = PCF.`idVersionFacturasProducto`
GROUP BY F.idFactura

UNION

SELECT F.Fecha ,Per.`Nombre` AS Cliente,F.idFactura AS NumFact,
SUM(PCF.`Cantidad`) AS TotalItem,F.Descuento,
((F.`TotalTarjeta`+F.`TotalContado`+FP.`Saldo`) / (1 - ((F.Descuento) / 100))) AS SubTotal,(F.`TotalTarjeta`+F.`TotalContado`+FP.`Saldo`) AS TotalFacturado
FROM Factura AS F, productocantidadfact AS PCF, persona AS Per, facturaspendientes AS FP
WHERE SUBSTRING(F.Fecha,1,10) BETWEEN ? AND ? AND PCF.`idFactura`=F.`idFactura` AND F.`idCliente`=Per.`idPersona` 
AND F.`Concepto`!="Devolucion" AND F.`Concepto`!="Modificada" AND F.`Estado`= "I" AND F.`Concepto`!="Cancelada"
AND F.`idVersionFactura` = PCF.`idVersionFacturasProducto` AND F.`idFactura` = FP.`idFactura` AND F.`idVersionFactura` = FP.`idVersionFactPendientes`
GROUP BY F.idFactura
;















-- SELECT F.Fecha ,Per.`Nombre` AS Cliente,F.idFactura AS NumFact,
-- SUM(PCF.`Cantidad`) AS TotalItem,F.Descuento,
-- ((F.`TotalTarjeta`+F.`TotalContado`) / (1 - ((F.Descuento) / 100))) AS SubTotal,(F.`TotalTarjeta`+F.`TotalContado`) AS TotalFacturado
-- FROM Factura AS F, productocantidadfact AS PCF, persona AS Per
-- WHERE SUBSTRING(F.Fecha,1,10) BETWEEN ? AND ? AND 
-- PCF.`idFactura`=F.`idFactura` AND F.`idCliente`=Per.`idPersona` 
-- AND F.`Concepto`!="Devolucion" AND F.`Concepto`!="Modificada" AND F.`Estado`= "I"
--  AND F.`idVersionFactura` = PCF.`idVersionFacturasProducto`
-- GROUP BY F.idFactura;


