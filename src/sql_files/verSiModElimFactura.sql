SELECT F.`Fecha`
FROM factura AS F
WHERE F.`idFactura`=? AND F.`Estado`='A' AND F.`Fecha` BETWEEN ? AND ?;
