SELECT F.Fecha,F.Concepto,F.idFactura,F.TipoPago,F.TotalFacturado
FROM factura AS F
WHERE F.Estado='A' AND F.Concepto ='Cancelada' AND F.Fecha BETWEEN ? AND ?
ORDER BY F.Concepto,F.TipoPago;


